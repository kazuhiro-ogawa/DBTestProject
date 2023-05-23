package com.dbtest.db.model.entity;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfo {
	/* 社員番号 */	@Id
	private Integer code;
	/* 入社日 */
	@Column(value="join_date")
	private Date joinDate;
	/* ふりがな */
	private String hurigana;
	/* 名前 */
	private String name;
	/* 部署名 */
	private String department;
	/* 所定労働日数 */
	private Integer working_days;
	/* 有給休暇発生日（基準日） */
	private Date reference_date;
	/* 年次有給休暇管理簿作成日 */
	private Date annual_paid_leave_report_date;
	/* 有給休暇付与日数 */
	private Integer granted_paid_leave_days;
	/* 有給休暇の使用トータル日数 */
	private Integer total_paid_leave_used_days;
	/* 有給休暇残数 */
	private Integer remaining_paid_leave_days;
}
