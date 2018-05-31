/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsystem;

/**
 *
 * @author Saqib kamal
 */
import java.sql.*;

public class ExamData {
	Connection cn = null;
	String sblank="";
	String sstar="";
	Statement st;
	String sql;
	ResultSet rs;
	ExamData()
	{
		 try {
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            cn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Saqib kamal/Documents/NetBeansProjects/ExamSystem/exam.mdb");
	            st=cn.createStatement();
	            System.out.println("connection established...");

	        } catch (Exception e) {
	            System.out.println("inside get connection catch ");
	            System.out.println("Exception : " + e);
	            e.printStackTrace();
	        }
		
	}
	public Connection getConnection()
	{
       
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            cn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Saqib kamal/Documents/NetBeansProjects/ExamSystem/exam.mdb");
            System.out.println("connection established...");

        } catch (Exception e) {
            System.out.println("inside get connection catch ");
            System.out.println("Exception : " + e);
            e.printStackTrace();
        }
        return cn;

    }
	public ResultSet selectCols(String cols,String table,String condtion)
	{
		if(cols.equals(sblank))
			cols="*";
		if(!condtion.equals(sblank))
			condtion=" Where "+condtion;
		String sql="select "+cols+" from "+table+"  "+condtion+"";
		//System.out.println(sql);
		try
		{
			rs=st.executeQuery(sql);
		} 
		catch (Exception e) 
		{
			System.out.println("inside get connection catch ");
			System.out.println("Exception : " + e);
			e.printStackTrace();
		}
		return rs;
	}
	//select_cols ends here 
	public void insertData(String cols,String table,String values)
	{
		
		try
		{
			if(!cols.isEmpty())
			{
				sql="insert into "+table+"("+cols+") values("+values+") ";
			}
			else
			{
				sql="insert into "+table+" values("+values+")";
			}
			System.out.println(sql);
			st.execute(sql);
		}
		catch (Exception e) 
		{
			System.out.println("inside get connection catch ");
			System.out.println("Exception : " + e);
			e.printStackTrace();
		}
	}
}

