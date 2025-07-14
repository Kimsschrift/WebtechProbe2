package de.htwberlin.web.api;

import de.htwberlin.service.QuotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/quotes")
public class QuotesRestController {

    private final QuotesService quotesService;

    public QuotesRestController(QuotesService quotesService) {
        this.quotesService = quotesService;
    }

    @GetMapping
    public ResponseEntity<QuoteResponse> getQuotesByIndex(@RequestParam int index) {
        String quoteText = quotesService.getQuote(index);
        var response = new QuoteResponse(quoteText);
        return ResponseEntity.ok(response);

    }

}
