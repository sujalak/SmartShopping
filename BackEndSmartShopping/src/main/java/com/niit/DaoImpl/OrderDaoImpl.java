package com.niit.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.OrderDao;
import com.niit.Model.Order;
import com.niit.Model.Order;
@Transactional
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao{
	@Autowired
	private SessionFactory sessionFactory;
	

	public OrderDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	private Session getCurrentSession() {

        return sessionFactory.getCurrentSession();
    }
	@Override
	public List<Order> listOrder() {
		return getCurrentSession().createQuery("from OrderItem").list();
	}
	@Override
	public boolean insertOrder(Order order) {
try {
			System.out.println("ORDER");
			getCurrentSession().saveOrUpdate(order);
			System.out.println("successfully order saved");
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	@Override
	public boolean deleteOrder(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order getOrderByID(String id) {
		return  (Order) sessionFactory.getCurrentSession().createQuery("from OrderItem where id = '"+id + "'").uniqueResult();
	}

	@Override
	public List<Order> userOrderList(String uname) {
		 List<Order> list=sessionFactory.getCurrentSession().createQuery("from OrderItem where u_id="+"'"+uname+"'").list();
			
			
			if(list!=null&& !list.isEmpty())
			{
				return list;
			}
			return null;

}
}
