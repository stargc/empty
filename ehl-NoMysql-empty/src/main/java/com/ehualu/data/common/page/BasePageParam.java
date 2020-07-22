package com.ehualu.data.common.page;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class BasePageParam {
	// 当前页码
	@Min(value = 1)
	private long num;
	// 起始索引
	@Min(value = 0)
	@Max(value = Long.MAX_VALUE)
	private long index;
	@Valid
	private List<SortBean> sort;

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}

	public List<SortBean> getSort() {
		return sort;
	}

	public void setSort(List<SortBean> sort) {
		this.sort = sort;
	}

	static class SortBean {
		String field;
		@Pattern(regexp = "^(asc)|(desc)$", message = "非法的排序规则", flags = Pattern.Flag.CASE_INSENSITIVE)
		String order;

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getOrder() {
			return order;
		}

		public void setOrder(String order) {
			this.order = order;
		}
	}
}
