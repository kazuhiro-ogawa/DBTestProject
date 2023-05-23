package com.dbtest.db.controller;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dbtest.db.SpringFXMLLoader;
import com.dbtest.db.model.entity.EmployeeInfo;
import com.dbtest.db.model.service.EmployeeInfoService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

@Controller
public class TestSceneController {

	@Autowired
	private SpringFXMLLoader fxmlLoader;

	@Autowired
	EmployeeInfoService service;
	//EmployeeInfoServiceImpl service;

    @FXML
    private Button allBtn;

    @FXML
    private TableView<EmployeeInfo> datatable;

    @FXML
    private TableColumn<EmployeeInfo, Date> annual_paid_leave_report_date_col;

    @FXML
    private TableColumn<EmployeeInfo, Integer> code_col;

    @FXML
    private TableColumn<EmployeeInfo, String> department_col;

    @FXML
    private TableColumn<EmployeeInfo, Integer> granted_paid_leave_days_col;

    @FXML
    private TableColumn<EmployeeInfo, String> hurigana_col;

    @FXML
    private TableColumn<EmployeeInfo, Date> joindate_col;

    @FXML
    private TableColumn<EmployeeInfo, String> name_col;

    @FXML
    private TableColumn<EmployeeInfo, Date> reference_date_col;

    @FXML
    private TableColumn<EmployeeInfo, Integer> total_paid_leave_used_days_col;

    @FXML
    private TableColumn<EmployeeInfo, Integer> remaining_paid_leave_days_col;

    @FXML
    private TableColumn<EmployeeInfo, Integer> working_days_col;

    @FXML
    private Button insertBtn;

    @FXML
    private TextField codeBox;

    @FXML
    private TextField deleteBox;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button findCodeBtn;

    @FXML
    private Label resultDelete;

    @FXML
    private Label resultFindCode;

    @FXML
    private Label resultUpdate;

    @FXML
    private TextField updateBox;

    @FXML
    private Button updateBtn;

    @FXML
    private AnchorPane findJoinAndDepartment;

    @FXML
    private Button findJoinAndDepBtn;

    @FXML
    private TextField depMultiple;

    @FXML
    private Button fineMultiple;

    @FXML
    private TextField nameMultiple;

    @FXML
    private TextField wdaysMultiple;


    @FXML
    void initialize() {
        assert allBtn != null : "fx:id=\"allBtn\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert annual_paid_leave_report_date_col != null : "fx:id=\"annual_paid_leave_report_date_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert codeBox != null : "fx:id=\"codeBox\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert code_col != null : "fx:id=\"code_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert datatable != null : "fx:id=\"datatable\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert deleteBox != null : "fx:id=\"deleteBox\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert deleteBtn != null : "fx:id=\"deleteBtn\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert depMultiple != null : "fx:id=\"depMultiple\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert department_col != null : "fx:id=\"department_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert findCodeBtn != null : "fx:id=\"findCodeBtn\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert findJoinAndDepBtn != null : "fx:id=\"findJoinAndDepBtn\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert fineMultiple != null : "fx:id=\"fineMultiple\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert granted_paid_leave_days_col != null : "fx:id=\"granted_paid_leave_days_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert hurigana_col != null : "fx:id=\"hurigana_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert insertBtn != null : "fx:id=\"insertBtn\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert joindate_col != null : "fx:id=\"joindate_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert nameMultiple != null : "fx:id=\"nameMultiple\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert name_col != null : "fx:id=\"name_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert reference_date_col != null : "fx:id=\"reference_date_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert remaining_paid_leave_days_col != null : "fx:id=\"remaining_paid_leave_days_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert resultDelete != null : "fx:id=\"resultDelete\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert resultFindCode != null : "fx:id=\"resultFindCode\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert resultUpdate != null : "fx:id=\"resultUpdate\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert total_paid_leave_used_days_col != null : "fx:id=\"total_paid_leave_used_days_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert updateBox != null : "fx:id=\"updateBox\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert updateBtn != null : "fx:id=\"updateBtn\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert wdaysMultiple != null : "fx:id=\"wdaysMultiple\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert working_days_col != null : "fx:id=\"working_days_col\" was not injected: check your FXML file 'TestScene.fxml'.";


		code_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfo, Integer>("code"));
		hurigana_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfo, String>("hurigana"));
		name_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfo, String>("name"));
		joindate_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfo, Date>("joinDate"));
		department_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfo, String>("department"));
		working_days_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfo, Integer>("working_days"));
		reference_date_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfo, Date>("reference_date"));
		annual_paid_leave_report_date_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfo, Date>("annual_paid_leave_report_date"));
		granted_paid_leave_days_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfo, Integer>("granted_paid_leave_days"));
		remaining_paid_leave_days_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfo, Integer>("remaining_paid_leave_days"));
		total_paid_leave_used_days_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfo, Integer>("total_paid_leave_used_days"));

    }


    @FXML
    void allBtn_OnClick(ActionEvent event) {

    	clearTable();

		Iterable<EmployeeInfo> empinfo = service.selectAll();



		for(EmployeeInfo emp : empinfo) {
			System.out.println(emp.getWorking_days());
			// サンプルデータを1行追加
			datatable.getItems().add(new EmployeeInfo(emp.getCode()
													,emp.getJoinDate()
													,emp.getHurigana()
													,emp.getName()
													,emp.getDepartment()
													,emp.getWorking_days()
													,emp.getReference_date()
													,emp.getAnnual_paid_leave_report_date()
													,emp.getGranted_paid_leave_days()
													,emp.getTotal_paid_leave_used_days()
													,emp.getRemaining_paid_leave_days()
									));
		}
    }

    @FXML
    void insertBtn_OnClick(ActionEvent event) {

    	clearTable();

    	EmployeeInfo empinfo = new EmployeeInfo(null
    			,Date.valueOf("2016-04-01")
    			,"やまだたろう"
    			,"山田太郎"
    			,"品質保証部"
    			,300
    			,Date.valueOf("2016-04-01")
    			,Date.valueOf("2016-04-01")
    	    	,19
    			,3
    			,16);

		try {
			service.insertEmployeeInfo(empinfo);
			allBtn_OnClick(event);

		}catch(Exception e){
			e.printStackTrace();
			if (e.getCause() instanceof InvocationTargetException) {
				Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
				targetException.printStackTrace();
			}
		}
    }

    @FXML
    void findCodeBtn_OnClick(ActionEvent event) {

    	clearTable();

		try {

			Optional<EmployeeInfo> optional = service.findById(Integer.parseInt(codeBox.getText()));
			EmployeeInfo empinfo;

			if (optional.isPresent()) {
			    empinfo = optional.get();
				datatable.getItems().add(new EmployeeInfo(empinfo.getCode()
						,empinfo.getJoinDate()
						,empinfo.getHurigana()
						,empinfo.getName()
						,empinfo.getDepartment()
						,empinfo.getWorking_days()
						,empinfo.getReference_date()
						,empinfo.getAnnual_paid_leave_report_date()
						,empinfo.getGranted_paid_leave_days()
						,empinfo.getTotal_paid_leave_used_days()
						,empinfo.getRemaining_paid_leave_days()
				));
			} else {
			    System.out.println("Value was null");
			}

		}catch(Exception e){
			e.printStackTrace();
			if (e.getCause() instanceof InvocationTargetException) {
				Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
				targetException.printStackTrace();
			}
		}
    }

    @FXML
    void updateBtn_OnClick(ActionEvent event) {
    	clearTable();

		Optional<EmployeeInfo> optional = service.findById(Integer.parseInt(updateBox.getText()));
		EmployeeInfo empinfo;

		if (optional.isPresent()) {
		    empinfo = optional.get();
		} else {
		    System.out.println("Value was null");
		    return;
		}

		empinfo.setJoinDate(Date.valueOf("1990-04-01"));

		try {
			service.insertEmployeeInfo(empinfo);
			allBtn_OnClick(event);

		}catch(Exception e){
			e.printStackTrace();
			if (e.getCause() instanceof InvocationTargetException) {
				Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
				targetException.printStackTrace();
			}
		}
    }

    @FXML
    void deleteBtn_OnClick(ActionEvent event) {

    	if(service.existsById(Integer.parseInt(deleteBox.getText()))) {
    		service.deleteById(Integer.parseInt(deleteBox.getText()));
    		clearTable();
    		allBtn_OnClick(event);
    	}else {
    		System.out.println("Value was null");
    	}

    }

    @FXML
    void findJoinAndDepBtn_OnClick(ActionEvent event) {
    	Iterable<EmployeeInfo> empinfo = service.findByJoinDateAndDepartment(Date.valueOf("2013-04-02"), "総務部");
    	clearTable();
		for(EmployeeInfo emp : empinfo) {
			System.out.println(emp.getName());
			// サンプルデータを1行追加
			datatable.getItems().add(new EmployeeInfo(emp.getCode()
													,emp.getJoinDate()
													,emp.getHurigana()
													,emp.getName()
													,emp.getDepartment()
													,emp.getWorking_days()
													,emp.getReference_date()
													,emp.getAnnual_paid_leave_report_date()
													,emp.getGranted_paid_leave_days()
													,emp.getTotal_paid_leave_used_days()
													,emp.getRemaining_paid_leave_days()
									));
		}
    }

    @FXML
    void fineMultipleBtn_OnClick(ActionEvent event) {

    	//nameMultiple.getText(), depMultiple.getText(), Integer.parseInt(wdaysMultiple.getText())
    	Iterable<EmployeeInfo> empinfo = service.findByParams("山田太郎" ,null, null);
    	clearTable();
		for(EmployeeInfo emp : empinfo) {
			System.out.println(emp);
			// サンプルデータを1行追加
			datatable.getItems().add(new EmployeeInfo(emp.getCode()
													,emp.getJoinDate()
													,emp.getHurigana()
													,emp.getName()
													,emp.getDepartment()
													,emp.getWorking_days()
													,emp.getReference_date()
													,emp.getAnnual_paid_leave_report_date()
													,emp.getGranted_paid_leave_days()
													,emp.getTotal_paid_leave_used_days()
													,emp.getRemaining_paid_leave_days()
									));
		}

    }

    void clearTable() {
    	datatable.getItems().clear();
    	datatable.refresh();
    }
}
