package jp.co.sss.crud.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.crud.dto.UserEmpDto;
import jp.co.sss.crud.form.ChangeForm;
import jp.co.sss.crud.form.TopForm;
import jp.co.sss.crud.service.EmployeeService;



import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;



public class DeleteAction extends LookupDispatchAction {

    protected Map<String, String> getKeyMethodMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("button.delete.check", "check");
        map.put("button.delete.finish", "complete");

        return map;
    }

    public ActionForward check(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {



        return mapping.findForward("check");
    }



    public ActionForward complete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


    	ChangeForm changeForm = (ChangeForm) form;
    	EmployeeService empService = new EmployeeService();

    	int count = empService.deleteData(changeForm);

        return mapping.findForward("complete");

    }
}