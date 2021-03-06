package com.koreait.cset.command.products;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.cset.common.CsetCommand;
import com.koreait.cset.dao.ProductsDAO;

public class ProductsSearchCommand implements CsetCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String searchBox = request.getParameter("searchBox");
		
		ProductsDAO pDAO = sqlSession.getMapper( ProductsDAO.class );
		model.addAttribute("plist", pDAO.productsSearch(searchBox) );
	}

}