package com.biz.rbooks.repository;

import org.apache.ibatis.jdbc.SQL;

/*
 * 코드가 길어지는 INSERT, UPDATE SQL문에 대한 문자열을 만드는 코드
 */
public class BookSQL {
	public String insert_sql() {
		return new SQL() {
			{
				INSERT_INTO("tbl_books");
				INTO_COLUMNS("b_code");
				INTO_COLUMNS("b_name");
				INTO_COLUMNS("b_author");
				INTO_COLUMNS("b_comp");
				INTO_COLUMNS("b_year");
				INTO_COLUMNS("b_page");
				INTO_COLUMNS("b_iprice");
				
				INTO_VALUES("#{b_code, jdbcType=VARCHAR}");
				INTO_VALUES("#{b_name, jdbcType=VARCHAR}");
				INTO_VALUES("#{b_author, jdbcType=VARCHAR}");
				INTO_VALUES("#{b_comp, jdbcType=VARCHAR}");
				INTO_VALUES("#{b_year, jdbcType=VARCHAR}");
				INTO_VALUES("#{b_page, jdbcType=VARCHAR}");
				INTO_VALUES("#{b_iprice, jdbcType=VARCHAR}");
			}
		}.toString();
	}
	
	public String update_sql() {
		return new SQL() {
			{
				UPDATE("tbl_books");
				WHERE("b_code = #{b_code, jdbcType=VARCHAR}");
				SET("b_name = #{b_name, jdbcType=VARCHAR}");
				SET("b_author = #{b_author, jdbcType=VARCHAR}");
				SET("b_comp = #{b_comp, jdbcType=VARCHAR}");
				SET("b_year = #{b_year, jdbcType=VARCHAR}");
				SET("b_page = #{b_page, jdbcType=VARCHAR}");
				SET("b_iprice = #{b_iprice, jdbcType=VARCHAR}");
			}
		}.toString();
	}
}
