package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Image;
import com.revature.util.HibernateUtil;

public class ImageDaoImpl implements ImageDao {

	@Override
	public List<Image> getImages() {
		Session s = HibernateUtil.getSession();
		
		List<Image> il = s.createQuery("from Image").list();
		
		s.close();
		return il;
	}

	@Override
	public Image getImageById(int id) {
		Session s = HibernateUtil.getSession();
		
		// Using load since image loading is relatively costly
		Image image = (Image) s.load(Image.class, id);
		
		s.close();
		return image;
	}

	@Override
	public int createImage(Image u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		int id = (int) s.save(u);
		
		tx.commit();
		s.close();
		
		return id;
	}

	@Override
	public int updateImage(Image u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteImage(Image u) {
		// TODO Auto-generated method stub
		return 0;
	}

}
