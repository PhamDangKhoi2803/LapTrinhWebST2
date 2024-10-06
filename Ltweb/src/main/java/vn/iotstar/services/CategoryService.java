package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.CategoryModel;

public interface CategoryService {
	List<CategoryModel> findAll();

	CategoryModel findById(int id);

	CategoryModel findName(String name);

	List<CategoryModel> searchByName(String keyword);

	void insert(CategoryModel category);

	void update(CategoryModel category);

	void delete(int id);

	void updateStatus(int id, int status);
}
