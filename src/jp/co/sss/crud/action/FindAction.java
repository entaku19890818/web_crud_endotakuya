package jp.co.sss.crud.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.crud.dto.PageDto;
import jp.co.sss.crud.dto.UserEmpDto;
import jp.co.sss.crud.form.TopForm;
import jp.co.sss.crud.service.DepartmentService;
import jp.co.sss.crud.service.EmployeeService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



/**
 *
 * @author Edu
 *
 */
public final class FindAction extends Action {




	private static final int PAGE_COUNT = 10;

	/**
	 * 検索結果をページングで取得し、情報をrequestへ格納する
	 */
	public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response) {

		TopForm topForm = (TopForm) form;

		EmployeeService empService = new EmployeeService();
    	DepartmentService deptService = new DepartmentService();

    	/**
    	 *
    	 */
		String findColumn = topForm.getFindColumn();

		//現在見ているページを宣言
    	int selectPage = 0;
        Date date = new Date();
        System.out.println(date.toString());


    	if (request.getParameter("pageNo") != null){
    		//現在選択されているページを取得
    		selectPage = Integer.parseInt(request.getParameter("pageNo"));
    	}



		//ユーザー情報を検索条件によって
		PageDto pageDto = empService.getAllEmpData(findColumn, topForm, selectPage, PAGE_COUNT);

    	// 部署情報の動的なselectボタンのデータの生成
    	UserEmpDto[] selectDeptDto = deptService.getUserEmpDto();


    	if (pageDto.getUserEmpDto().length <= 0){
    		boolean getTopDataFlag = true;

    		//検索結果が0件の場合、検索結果が存在しないことを知らせるため、HttpセッションへFlagを格納する
    		request.setAttribute("getTopDataFlag", getTopDataFlag);
    	}

			//Httpセッションへページ情報を格納する
    		request.setAttribute("pageDto", pageDto);

    		//Httpセッションへ社員情報を格納する
            request.setAttribute("userEmpDto", pageDto.getUserEmpDto());

            //Httpセッションへ部署情報を格納する
            request.setAttribute("selectDeptDto", selectDeptDto);



            HttpSession session = request.getSession(true);
            int authority = (Integer) session.getAttribute("authority");


            //Httpセッションへログイン情報を格納する

            Date date2 = new Date();
            System.out.println(date2.toString());

        	if ( authority == 2){
        		return mapping.findForward("manege");
        	}
        	//最悪一般にすべるように・・・
        	return mapping.findForward("general");



    }
}