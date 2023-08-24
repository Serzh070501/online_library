package org.library.convertor;

import org.library.model.entity.Book;
import org.library.rest.dto.BookDTO;

import java.util.List;

public interface BookConvertor {
    Book convertToEntity(BookDTO bookDTO);

    BookDTO convertToDTO(Book book);

    List<BookDTO> bulkConvert(List<Book> books);
}
