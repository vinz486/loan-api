package com.bigbank.loan.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.bigbank.loan.engine.quote.Lender;
import com.bigbank.loan.excetpion.InvalidMarketData;
import com.bigbank.loan.excetpion.InvalidMarketId;
import com.opencsv.bean.CsvToBeanBuilder;


@Component
public class MarketDataSource extends AbstractService
{
    private static Map<String, String> marketFilePath = new HashMap<>();

    static
    {
        marketFilePath.put("it", "/market-it.csv");
        marketFilePath.put("en", "/market-en.csv");
    }

    @SuppressWarnings("unchecked")
    public List<Lender> find(String market)
    {

        String marketFile = marketFilePath.get(market);

        if (marketFile == null)
        {
            throw new InvalidMarketId("Provided market id is invalid");
        }

        final FileReader marketFileReader;

        try
        {
            Resource resource = new ClassPathResource(marketFile);

            marketFileReader = new FileReader(resource.getFile());

        }
        catch (IOException ioe)
        {

            throw new InvalidMarketId("Invalid market : " + market);
        }

        final List<Lender> lenders;

        try
        {

            lenders = new CsvToBeanBuilder(marketFileReader).withType(Lender.class).withThrowExceptions(true).build().parse();
        }
        catch (RuntimeException e)
        {

            throw new InvalidMarketData("Internal data error");
        }

        if (lenders.isEmpty())
        {
            throw new InvalidMarketData("Internal data error");
        }

        return lenders;
    }
}
