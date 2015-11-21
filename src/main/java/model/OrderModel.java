package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.HibernateUtil;
import domain.Excludeddate;
import domain.Orderline;
import domain.OrderlineId;
import domain.User;
import domain.Userorder;

public class OrderModel extends AbstractModel<Userorder, Short> {

	public OrderModel(){
		super(Userorder.class);
	}
	
	public void createOrder(User u, Set<Orderline> o) throws Exception{
		
		Session session = HibernateUtil.currentSession();
		try{
			Transaction tx = session.beginTransaction();
			try{
				Userorder order = new Userorder();
				order.setOrderDate(new Date());
				order.setUser(u);
				
				Short order_id = (Short)session.save(order);
				
				Iterator<Orderline> i = o.iterator();
				while(i.hasNext()){
					Orderline line = i.next();
					Short product_id = line.getProduct().getProductId();
					line.setId(new OrderlineId(product_id, order_id));
					session.save(line);
				}
				
        		tx.commit();
			}catch(Exception ex){
				tx.rollback();
				throw(ex);
			}
		}finally{
			HibernateUtil.closeSession();
		}
	}
}
