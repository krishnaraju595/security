package io.github.hengyunabc.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.github.hengyunabc.sample.models.Employee;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author hengyunabc 2017-07-29
 *
 */
@Controller
public class MainController {

	@Autowired
	//@Qualifier("dbDataSource")
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("date", new Date().toString());
        return "home";
    }


	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		int i = Integer.parseInt(request.getParameter("t1"));
		int j = Integer.parseInt(request.getParameter("t2"));
        int k = i+j;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result",k);
		return mv;
	}

	@RequestMapping("/hello")
	public String helloWorld(Model model) {
		model.addAttribute("name", "中文");
		return "hello";
	}

	@RequestMapping("/shell")
	public ModelAndView runShellCommands(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String command = request.getParameter("command");

		Process p= Runtime.getRuntime().exec("cmd /c "+command);

		StringBuilder everything = new StringBuilder();
		String s;
		System.out.println(p.getOutputStream());
		BufferedReader stdInput = new BufferedReader(new
				InputStreamReader(p.getInputStream()));
		while((s=stdInput.readLine())!=null){
			everything.append(s);

		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result",everything);
		return mv;
	}

	@RequestMapping("/employees")
	public  ModelAndView getEmployees(Model model,@RequestParam() String empId, Employee employee){
		System.out.println("Employees id:"+empId);
		//id ="105 OR 1=1";
		String query = "select id, name, role from Employee where id="+empId;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);

		for(Map<String,Object> empRow : empRows){
			Employee emp = new Employee();
			emp.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
			emp.setName(String.valueOf(empRow.get("name")));
			emp.setRole(String.valueOf(empRow.get("role")));
			empList.add(emp);
		}
		System.out.println(empList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("employees",empList);
		return mv;
	}

	@RequestMapping("/hello-from-common")
	public ModelAndView helloFromCommon(Model model) {
		List<Employee> empList = new ArrayList<Employee>();
		//JDBC Code - Start
		String query = "select id, name, role from Employee";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);

		for(Map<String,Object> empRow : empRows){
			Employee emp = new Employee();
			emp.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
			emp.setName(String.valueOf(empRow.get("name")));
			emp.setRole(String.valueOf(empRow.get("role")));
			empList.add(emp);
		}
        System.out.println(empList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("employees",empList);
		return mv;
		//model.addAttribute("name", "hello-from-common");
	}



//	@RequestMapping("/rest-emps")
//	public String getAllEmployees(Model model) {
//		List<Employee> empList = new ArrayList<Employee>();
//		//JDBC Code - Start
//		String query = "select id, name, role from Employee";
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//
//		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
//        String ptc= "test";
//		for(Map<String,Object> empRow : empRows){
//			Employee emp = new Employee();
//			emp.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
//			emp.setName(String.valueOf(empRow.get("name")));
//			emp.setRole(String.valueOf(empRow.get("role")));
//			empList.add(emp);
//		}
//
//		model.addAttribute("name", empList);
//		return "rest-emps";
//		//return empList;
//	}

}
