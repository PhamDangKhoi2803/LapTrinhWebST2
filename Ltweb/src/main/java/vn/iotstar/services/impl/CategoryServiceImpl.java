package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	public ICategoryDao cateDao = new CategoryDaoImpl();

	@Override
	public List<CategoryModel> findAll() {
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {
		return cateDao.findById(id);
	}

	@Override
	public CategoryModel findName(String name) {
		return cateDao.findName(name);
	}

	@Override
	public List<CategoryModel> searchByName(String keyword) {
		// TODO Auto-generated method stub
		return cateDao.searchByName(keyword);
	}

	@Override
	public void insert(CategoryModel category) {
		// TODO Auto-generated method stub
		/*
		 * CategoryModel cate = this.findName(category.getCategoryname()); if (cate ==
		 * null) { cateDao.insert(category); }
		 */
		cateDao.insert(category);
	}

	@Override
	public void update(CategoryModel category) {
		// TODO Auto-generated method stub
		CategoryModel cate = this.findById(category.getCategoryid());
		if (cate != null) {
			cateDao.update(category);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cateDao.delete(id);
	}

	@Override
	public void updateStatus(int id, int status) {
		// TODO Auto-generated method stub
		cateDao.updateStatus(id, status);
	}

}
