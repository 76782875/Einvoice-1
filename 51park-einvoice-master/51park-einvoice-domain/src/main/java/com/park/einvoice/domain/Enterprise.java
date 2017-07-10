package com.park.einvoice.domain;

import java.util.Date;

import com.park.einvoice.domain.mybatis.Column;
import com.park.einvoice.domain.mybatis.Index;
import com.park.einvoice.domain.mybatis.Table;

@Table("cc_ei_enterprise")
public class Enterprise{
	@Index("id")
	private Integer id;
	@Column("enterprise_code")
	private String enterprise_code;
	@Column("enterprise_name")
	private String enterprise_name;
	@Column("taxpayer_num")
	private String taxpayer_num;
	@Column("legal_person_name")
	private String legal_person_name;
	@Column("contact_name")
	private String contact_name;
	@Column("contact_email")
	private String contact_email;
	@Column("contact_phone")
	private String contact_phone;
	@Column("region_code")
	private String region_code;
	@Column("city_name")
	private String city_name;
	@Column("address")
	private String address;
	@Column("tax_reg_cer")
	private String tax_reg_cer;
	//can_paper_invoice是否允许开具纸质发票，对应参数的isPermitPaperInvoice
	@Column("can_paper_invoice")
	private Integer can_paper_invoice;
	@Column("operate_type")
	private Integer operate_type;
	@Column("create_time")
	private Date create_time;
	@Column("update_time")
	private Date update_time;
	@Column("add_user")
	private String add_user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEnterprise_code() {
		return enterprise_code;
	}
	public void setEnterprise_code(String enterprise_code) {
		this.enterprise_code = enterprise_code;
	}
	public String getEnterprise_name() {
		return enterprise_name;
	}
	public void setEnterprise_name(String enterprise_name) {
		this.enterprise_name = enterprise_name;
	}
	public String getTaxpayer_num() {
		return taxpayer_num;
	}
	public void setTaxpayer_num(String taxpayer_num) {
		this.taxpayer_num = taxpayer_num;
	}
	public String getLegal_person_name() {
		return legal_person_name;
	}
	public void setLegal_person_name(String legal_person_name) {
		this.legal_person_name = legal_person_name;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	public String getContact_phone() {
		return contact_phone;
	}
	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}
	public String getRegion_code() {
		return region_code;
	}
	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTax_reg_cer() {
		return tax_reg_cer;
	}
	public void setTax_reg_cer(String tax_reg_cer) {
		this.tax_reg_cer = tax_reg_cer;
	}
	public Integer getCan_paper_invoice() {
		return can_paper_invoice;
	}
	public void setCan_paper_invoice(Integer can_paper_invoice) {
		this.can_paper_invoice = can_paper_invoice;
	}
	public Integer getOperate_type() {
		return operate_type;
	}
	public void setOperate_type(Integer operate_type) {
		this.operate_type = operate_type;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public String getAdd_user() {
		return add_user;
	}
	public void setAdd_user(String add_user) {
		this.add_user = add_user;
	}
	@Override
	public String toString() {
		return "Enterprise [enterprise_id=" + id + ", enterprise_code=" + enterprise_code
				+ ", enterprise_name=" + enterprise_name + ", taxpayer_num=" + taxpayer_num + ", legal_person_name="
				+ legal_person_name + ", contact_name=" + contact_name + ", contact_email=" + contact_email
				+ ", contact_phone=" + contact_phone + ", region_code=" + region_code + ", city_name=" + city_name
				+ ", address=" + address + ", tax_reg_cer=" + tax_reg_cer + ", can_paper_invoice=" + can_paper_invoice
				+ ", operate_type=" + operate_type + ", create_time=" + create_time + ", update_time=" + update_time
				+ ", add_user=" + add_user + "]";
	}
}
