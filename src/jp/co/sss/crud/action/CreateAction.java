package jp.co.sss.crud.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.crud.dto.UserEmpDto;
import jp.co.sss.crud.form.ChangeForm;
import jp.co.sss.crud.service.EmployeeService;




import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;



public class CreateAction extends LookupDispatchAction {

    protected Map<String, String> getKeyMethodMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("button.check", "check");
        map.put("button.finish", "finish");

        return map;
    }


    public ActionForward check(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

    	ChangeForm changeForm = (ChangeForm) form;
    	EmployeeService empService = new EmployeeService();

    	// Dto へ ChangeFormの内容を格納する
    	UserEmpDto userEmpDto = empService.chkInputData(changeForm);


    	//Dtoの内容を画面へ表示
    	request.setAttribute("userEmpDto", userEmpDto);




        return mapping.findForward("check");
    }



    public ActionForward finish(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


    	ChangeForm changeForm = (ChangeForm) form;
    	EmployeeService empService = new EmployeeService();

    	int count = empService.createData(changeForm);

        return mapping.findForward("finish");
    }
}