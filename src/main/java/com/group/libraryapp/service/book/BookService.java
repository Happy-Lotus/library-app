package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import com.group.libraryapp.repository.book.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;
    public BookService(BookRepository bookRepository,UserLoanHistoryRepository userLoanHistoryRepository,UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    }
    @Transactional
    public void loanBook(BookLoanRequest request){
        //책 정보 가져옴
        Book book = bookRepository.findByName(request.getBookName())
                        .orElseThrow(IllegalArgumentException::new);

        //대출 기록 정보 확인. 대출중이면 예외 발생
        if(userLoanHistoryRepository.existsByBookNameAndIsReturn(
                book.getName(),false)){
            throw new IllegalArgumentException("대출되어 있는 책입니다.");
        }

        //유저 정보 가져옴
        User user = userRepository.findByName(request.getUserName());
        //유저 정보와 책정보 기반으로 UserLoanHistory를 저장
        user.loanBook(book.getName());

//        userLoanHistoryRepository.save(new UserLoanHistory(
//                user,book.getName()
//        ));
    }

    @Transactional
    public void returnBook(BookReturnRequest request){
        //username이용해 user을 찾아 userid를 찾아야함
        User user = userRepository.findByName(request.getUserName());

        //userid와 책이름 이용해 대출 기록 찾아야함
//        UserLoanHistory userLoanHistory = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), request.getBookName())
//                .orElseThrow(IllegalArgumentException::new);
//        userLoanHistory.doReturn();

        user.returnBook(request.getBookName());
    }
}
