package core;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import storage.SQLConnector;

public class QuotesMapper {
    public QuotesMapper() {
    }
    
    public static ArrayList<Quote> getAllQuotes() {
        ArrayList<Quote> quotes = new ArrayList<>();
        try(SQLConnector connector = new SQLConnector(true)) {
            String sql = "SELECT * FROM quotes";
            PreparedStatement statement = connector.getConnection().prepareStatement(sql);
            ArrayList<HashMap<String,String>> quotesMap = connector.selectQuery(statement);
            for (HashMap<String, String> hashMap : quotesMap) {
                int id = Integer.parseInt(hashMap.get("id"));
                String author = hashMap.get("author");
                String text = hashMap.get("quote");
                quotes.add(new Quote(id,author,text));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return quotes;
    }
    
}
