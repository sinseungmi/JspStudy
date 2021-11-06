package chap06.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import chap06.model.Worldcup;
import chap06.model.WorldcupItem;

public class WorldcupDAO {
   
   private Connection conn;

   public WorldcupDAO(Connection conn) {
      this.conn = conn;
   }
   
   public int getNotYetCount() {
      String sql = "SELECT count(*) FROM worldcup WHERE status='M'";
      
      try (
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
      ) {
         rs.next();
         return rs.getInt(1);
      } catch (Exception e) {
         e.printStackTrace();
         return 0;
      }
   }
   
   public int getCount() {
      String sql = "SELECT count(*) FROM worldcup";
      
      try (
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
      ) {
         rs.next();
         return rs.getInt(1);
      } catch (Exception e) {
         e.printStackTrace();
         return 0;
      }
   }
   
   public int addQuestion(String question) {
      String sql = "INSERT INTO worldcup(wid, name) VALUES(worldcup_wid_seq.nextval, ?)";
      
      try (
            PreparedStatement pstmt = conn.prepareStatement(sql);
      ) {
         pstmt.setString(1, question);
         return pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
         return 0;
      }
   }
   
   public ArrayList<Worldcup> getWorldcupList() {
	   String sql = "SELECT * FROM worldcup";
	   
	   try (
			   PreparedStatement pstmt = conn.prepareStatement(sql);
			   ResultSet rs = pstmt.executeQuery();
		){
		   ArrayList<Worldcup> list = new ArrayList<>();
		   
		   while (rs.next()) {
			   list.add(new Worldcup(
					   rs.getInt(1),
					   rs.getString(2),
					   rs.getInt(3),
					   rs.getString(4)
				));
			   
		   }
		   return list;
		
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	   
   }
   
   public Worldcup getWorldcup(int wid) {
	   
	   String sql = "SELECT * FROM worldcup WHERE wid=?";
	   
	   try (
			   PreparedStatement pstmt = conn.prepareStatement(sql);			   
			){
		   pstmt.setInt(1, wid);
		   
		   try (
				   ResultSet rs = pstmt.executeQuery();				   
				 ){
			   rs.next();
			   return new Worldcup(
					   rs.getInt(1),
					   rs.getString(2),
					   rs.getInt(3),
					   rs.getString(4)
					   );
			   
		   }
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	   
   }
   
   public ArrayList<WorldcupItem> getWorldcupItemList(int wid) {
	   String sql = "SELECT * FROM worldcup_item WHERE wid=?";
	   
	   try (
			   PreparedStatement pstmt = conn.prepareStatement(sql);
			){
		    ArrayList<WorldcupItem> list = new ArrayList<>();
		   
		   	pstmt.setInt(1, wid);
		   	
		   	try (
		   			ResultSet rs = pstmt.executeQuery();		   			
		   		){
		   		
		   		while (rs.next()) {
		   			list.add(new WorldcupItem(
		   					rs.getInt(1),
		   					rs.getString(2),
		   					rs.getInt(3),
		   					rs.getInt(4),
		   					rs.getInt(5),
		   					rs.getInt(6)
		   					));
		   		}
		   		
		   	}
		   	return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	   
   }
   
   public ArrayList<WorldcupItem> getAllItemList() {
	   String sql = "SELECT * FROM worldcup_item";
	   
	   try (
			   PreparedStatement pstmt = conn.prepareStatement(sql);
			   ResultSet rs = pstmt.executeQuery();	
			   ){
		   ArrayList<WorldcupItem> list = new ArrayList<>();
		   while (rs.next()) {
			   list.add(new WorldcupItem(
					   rs.getInt(1),
					   rs.getString(2),
					   rs.getInt(3),
					   rs.getInt(4),
					   rs.getInt(5),
					   rs.getInt(6)
					   ));
		   }
		   
		   return list;
	   } catch (Exception e) {
		   e.printStackTrace();
		   return null;
	   }
	   
   }
   
   public int winItem(int id) {
	   
	   String sql = "UPDATE worldcup_item SET win=win+1 WHERE id=?";
	   
	   try (
			PreparedStatement pstmt = conn.prepareStatement(sql);   
			){
		   pstmt.setInt(1, id);
		   return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
   }
   
   public int loseItem(int id) {
	   
	   String sql = "UPDATE worldcup_item SET lose=lose+1 WHERE id=?";
	   
	   try (
			   PreparedStatement pstmt = conn.prepareStatement(sql);   
			   ){
		   pstmt.setInt(1, id);
		   return pstmt.executeUpdate();
	   } catch (Exception e) {
		   e.printStackTrace();
		   return 0;
	   }
   }
   
}







