package dictionnaire;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author pc
 */
public class WordBDD {

    Word word;

    public WordBDD(String word) {
        this.word = new Word(word);
    }

    public boolean insertWord() {
        String query = "insert into word values (?)";
        boolean b = false;
        try {
            Connection con = ConnectionBDD.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, word.getWord());
            int nbr = ps.executeUpdate();
            b = nbr == 1;
        } catch (Exception e) {
            System.out.println("deja exist");
        }
        return b;
    }

    public boolean updateWord(String old) {
        String query = "update  word set  word=? where word like ?";
        boolean b = false;
        try {
            Connection con = ConnectionBDD.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, word.getWord());
            ps.setString(2, old);

            int nbr = ps.executeUpdate();
            b = nbr == 1;
        } catch (Exception e) {
            System.out.println("deja exist");
            e.printStackTrace();
        }
        return b;
    }

    public boolean deleteWord() {
        String query = "delete from word where word like  ?";
        boolean b = false;
        try {
            Connection con = ConnectionBDD.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, word.getWord());
            int nbr = ps.executeUpdate();
            b = nbr == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public boolean getWord() {
        String query = "select * from word where word like  ?";
        boolean b = false;
        try {
            Connection con = ConnectionBDD.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, word.getWord());
            ResultSet rs = ps.executeQuery();
            b = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

}
