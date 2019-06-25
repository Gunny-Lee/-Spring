package dynamic;

import java.util.Map;

public class DynamicSql {
	public static String searchFriends(Map<String, Object> params) {
		String commandSql = "";
		String id = (String) params.get("id");
		String condition = (String) params.get("condition");
		String[] hashSplitSql = condition.split("#");//["인천,서울", "치킨"]
		commandSql = "select * from (select * from v3 where id in (select fid from friend where id='"+id+"')) where ";
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
		return commandSql;
	}
}
