package test;

import java.util.List;

import biz.service.UserService;
import biz.service.UserServiceImpl;
import biz.vo.FriendVO;
import biz.vo.UserVO;

public class Test01 {
	public static void main(String[] args) {
		String id = "1";
		String commandSql = "";
		String sql = "#서울#치킨";
		String[] hashSplitSql = sql.split("#");//["인천,서울", "치킨"]
		commandSql = "select * from (select * from test4 where id in (select fid from test6 where id="+id+")) where ";
		for(int i = 1; i < hashSplitSql.length; i++){
			String[] commaSplitSql= hashSplitSql[i].split(","); //["인천", "서울"]
			commandSql += "(";
			for(int j=0; j < commaSplitSql.length; j++){
				commandSql += "why like '%'||'"+commaSplitSql[j].trim()+"'||'%'";
				if(j < commaSplitSql.length-1)
					commandSql += " or ";
			}
			commandSql += ")";
			if(i < hashSplitSql.length-1)
				commandSql += " and ";
		}
		commandSql += ";";
		System.out.println(commandSql);

	}
}
