package com.feicuiedu.store.service;

import java.util.List;

import com.feicuiedu.store.dao.GoodsDao;
import com.feicuiedu.store.entity.Goods;
import com.feicuiedu.store.exception.ServiceException;

/**
 * 商品服务具体业务
 * 
 * @author 陈严
 */
public class GoodsService extends BaseService{

	private GoodsDao goodsDao;

	/**
	 * 新增goods对象
	 * 
	 * @param goods
	 * @throws ServiceException
	 */
	public void saveGoods(Goods goods) throws ServiceException {
		goodsDao = new GoodsDao();
		
		Goods rtnGoods = findById(goods.getId());
		
		
		if (rtnGoods == null) {
			
			//新增
			goodsDao.save(goods);
		}
		else {
			message = "商品id" + goods.getId() + "已经存在，不能够添加";
			throw new ServiceException(message);
		}
		
	}

	/**
	 * 修改goods对象
	 * 
	 * @param goods
	 * @throws ServiceException
	 */
	public void updateGoods(Goods goods) throws ServiceException {
		goodsDao = new GoodsDao();
		
		Goods rtnGoods = findById(goods.getId());
		
		// 如果查询不到这个对象，那么说明商品不存在，业务中断
		if (rtnGoods == null) {
			message = "商品id" + goods.getId() + "不存在，不能修改";
			throw new ServiceException(message);
			
		}

		goodsDao.update(goods);
		
	}

	public void deleteGoods(Goods goods) throws ServiceException {
		goodsDao = new GoodsDao();
		
		goodsDao.delete(goods);
	}

	/**
	 * 获取goods.data中的商品集合
	 * @return List<Goods>
	 * @throws ServiceException
	 */
	public List<Goods> queryGoods() throws ServiceException {
		goodsDao = new GoodsDao();
		return goodsDao.query();
	}

	/**
	 * 根据输入的商品id获取商品对象
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public Goods findById(Integer id) throws ServiceException {
		goodsDao = new GoodsDao();

		Goods rtnGoods = goodsDao.findById(id);

		return rtnGoods;
	}
}
