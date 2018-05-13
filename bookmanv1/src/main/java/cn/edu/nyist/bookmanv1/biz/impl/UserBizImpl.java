package cn.edu.nyist.bookmanv1.biz.impl;

import cn.edu.nyist.bookmanv1.Dao.LoginDao;
import cn.edu.nyist.bookmanv1.Dao.impl.LoginDaoImpl;
import cn.edu.nyist.bookmanv1.biz.UserBiz;

public class UserBizImpl implements UserBiz {

	@Override
	public boolean getFindNameAndPwd(String name, String pwd) {
		LoginDao loginDao=new LoginDaoImpl();
		return loginDao.getRet(name,pwd);
	}

}
