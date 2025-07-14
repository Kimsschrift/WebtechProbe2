package de.htwberlin;

import de.htwberlin.service.QuotesService;
import de.htwberlin.web.api.QuoteResponse;
import de.htwberlin.web.api.QuotesRestController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class QuotesRestControllerTest {

    @Mock
    private QuotesService quotesService;

    @InjectMocks
    private QuotesRestController quotesRestController;

    @Test
    void testGetQuotesByIndex() throws Exception {
        String expectedQuote = " Chuck Norris trägt keine Uhr. Er entscheidet wie spät es ist!";
        int index = 2;
        when(quotesService.getQuote(index)).thenReturn(expectedQuote);

       ResponseEntity<QuoteResponse> response = quotesRestController.getQuotesByIndex(index);

       assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
       assertThat(response.getBody()).isNotNull();
       assertThat(response.getBody().getQuote()).isEqualTo(expectedQuote);


    }
}
