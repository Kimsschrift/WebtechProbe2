package de.htwberlin.service;

import org.springframework.stereotype.Service;

@Service
public class QuotesServiceImpl implements QuotesService {

    /**
     * The method returns a selected Chuck Norris quote from the QUOTES list.
     * @param index - Determines which quote to choose from the list.
     * @throws IllegalArgumentException - Throws IllegalArgumentException if index is out of range.
     * @return The chosen Chuck Norris quote.
     */
    @Override
    public String getQuote(int index) {

        if (index < 0 || index >= QUOTES.size()) {
            throw new IllegalArgumentException("Index is out of range");
        }

        return QUOTES.get(index);
    }
}
