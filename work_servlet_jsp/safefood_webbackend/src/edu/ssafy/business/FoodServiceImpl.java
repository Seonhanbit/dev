package edu.ssafy.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.controller.delivery;
import edu.ssafy.model.FoodManagerImpl;
import edu.ssafy.model.FoodVO;
import edu.ssafy.model.IFoodManager;
import edu.ssafy.model.IMemManager;
import edu.ssafy.model.MemManagerImpl;
import edu.ssafy.model.MemVO;

public class FoodServiceImpl implements IFoodService{

	
	private IFoodManager foodmanager = new FoodManagerImpl();
	private IMemManager man = new MemManagerImpl();
	
	public FoodServiceImpl() {	}

	@Override
	public void pdetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<FoodVO> foodlist = foodmanager.getFoodList();
		//System.out.println(foodlist.size());
		FoodVO food = new FoodVO();
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		food = foodmanager.getFood(code);
		
		//System.out.println(food.toString());
		
		request.setAttribute("food", food);
		request.getRequestDispatcher("pdetail.jsp").forward(request, response);
	}

	@Override
	public void productInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<FoodVO> foodlist = foodmanager.getFoodList();
		request.setAttribute("foodlist", foodlist);
		request.getRequestDispatcher("productInfo.jsp").forward(request, response);
	}

	class cnt_keyword {
        String keyword;
        int cnt;
        
        public cnt_keyword(String keyword, int cnt){
            this.keyword = keyword;
            this.cnt = cnt;
        };
    }
    
    ArrayList<cnt_keyword> list = new ArrayList<>();
    
	@Override
	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cnt = 0;
		
		String st = request.getParameter("searchType");
		List<FoodVO> FoodList = null;
		String name = request.getParameter("search");
		if(name.equals(""))FoodList = foodmanager.getFoodList();
		
		else if(st.equals("상품명")) {
			FoodList = (List<FoodVO>) foodmanager.getFoodnamelist(name);
		}else {
			String pcom = name;
			FoodList = (List<FoodVO>) foodmanager.getFoodmaker(pcom);
		}
		//해당 단어가 들어가는 제품 수 count
		cnt = FoodList.size();
		
		//제품명 순으로 정렬
		Collections.sort(FoodList);
		
		request.setAttribute("cnt", cnt);
		request.setAttribute("foodlist", FoodList);
		
		//=============================================
		
		
		String keyword = request.getParameter("search");
        list.add(new cnt_keyword(keyword, 0));
        System.out.println(keyword);
        boolean chk=false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).keyword.equals(keyword)) {
                chk=true;
                list.get(i).cnt++;
                break;
            }
        }
        
        int max_cnt = Integer.MIN_VALUE;
        String str="";
        for(int i = 0; i < list.size(); i++) {
            if(max_cnt<list.get(i).cnt) {
                max_cnt=list.get(i).cnt;
                str=list.get(i).keyword;
            }
        }
        System.out.println(max_cnt);    
        request.getSession().setAttribute("key", str);//키값이 중복 "" 덮ㅇor바꾸기
        
		request.getRequestDispatcher("productInfo.jsp").forward(request, response);
		
		
		
		
	}
	
	@Override
	public void SignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 2.파라미터 작업(name 속성 쫓는다)
        String id = request.getParameter("pid");
        String pw1 = request.getParameter("ppw1");
        String pw2 = request.getParameter("ppw2");
        String name = request.getParameter("pname");
        String addr = request.getParameter("paddr");
        String email1=request.getParameter("pemail1");
        String email2=request.getParameter("pemail2");
        System.out.println(id);
        String email=email1+"@"+email2;
        
        String tel1=request.getParameter("ptel1");
        String tel2=request.getParameter("ptel2");
        String tel3=request.getParameter("ptel3");
        
        String tel=tel1+"-"+tel2+"-"+tel3;
        
        String[] alinfo=request.getParameterValues("hobby");
        String all = "";
        for (int i = 0; i < alinfo.length-1; i++) {
			all += alinfo[i]+", ";
		}
        all += alinfo[alinfo.length-1];
        // 3
        boolean res = man.addMem(id, pw1, name, addr, email, tel,all);
        // 4
        if (res) {
            String msg = "success";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("main.jsp").forward(request, response);
        } else {
            String msg = "fail";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }
		
	}

	@Override
	public void Login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String id = request.getParameter("mid");
		String pw = request.getParameter("mpw");
		boolean isLogin = man.isLogin(id, pw);
		if (isLogin) {
			//세션에 로그인 저장
			request.getSession().setAttribute("islogin", "isLogin");
			request.getSession().setAttribute("id",id);
			
			response.sendRedirect("main.jsp");
		} else {
			//구현 안됨
			
		}
	}

	@Override
    public void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("pid");
        boolean del = man.delMem(id);
        if (del) {
        	String msg = "success";
			request.setAttribute("msg", msg);
			request.getSession().invalidate();
			request.getRequestDispatcher("mypage.jsp").forward(request, response);
        } else {
        	String msg = "fail";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("mypage.jsp").forward(request, response);
        }
    }
    
	@Override
    public void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = request.getParameter("pid");
        String pw = request.getParameter("ppw");
        String name = request.getParameter("pname");
        String addr = request.getParameter("paddr");
        String email = request.getParameter("pemail");
        String tel = request.getParameter("ptel");
        String alinfo = request.getParameter("palinfo");
        boolean update = man.updateMem(id, pw, name, addr, email, tel, alinfo);
        if (update) {
            request.getRequestDispatcher("main.do?action=memInfo").forward(request, response);
        } else {
            request.setAttribute("result", id + "의 수정이 실패하였습니다");
            request.getRequestDispatcher("mypage.jsp").forward(request, response);
        }
    }

	@Override
	public void Logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//세션 지우면 돼 => 세션 모두 초기화돼
				request.getSession().invalidate();
				response.sendRedirect("main.jsp");
	}

	@Override
	public void memInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String) request.getSession().getAttribute("id");
		
		MemVO mem =  man.getMemInfo(id);
		request.setAttribute("info", mem);
		System.out.println(mem.getAlinfo());
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
		
	}

	@Override
	public void date(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int x = Integer.parseInt(request.getParameter("posx"));
		int y = Integer.parseInt(request.getParameter("posy"));			
		
		request.setAttribute("date", new delivery().execute(x,y));
		request.getRequestDispatcher("productInfo.jsp").forward(request, response);	
	}

	
	int[] calorie = new int[20];
    String[] name = new String[20];
	@Override
	public void itemInCalo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // TODO Auto-generated method stub
        int calo = Integer.parseInt(request.getParameter("calo"));
        for (int i = 1; i <= 20; i++) {
            FoodVO tmp = foodmanager.getFood(i);
            calorie[i - 1] = (int) Double.parseDouble(tmp.getCalory());
            name[i - 1] = tmp.getName();
        }
        int N = calorie.length;
        int maxCal = 0;
        boolean[] chk = new boolean[N];
        boolean[] finalChk = new boolean[N];
        for (int i = 0; i < (1 << N); i++) {
            int sumCal = 0;
            Arrays.fill(chk, false);
            for (int j = 0; j < N; j++) {
                if (((1 << j) & i) != 0) {
                    if (sumCal + calorie[j] <= calo) {
                        sumCal += calorie[j];
                        chk[j] = true;
                    }
                }
            }
            if (maxCal < sumCal) {
                maxCal = sumCal;
                finalChk=chk.clone();
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < finalChk.length; i++) {
            if(finalChk[i]==true) {
                sb.append(name[i]).append("<br>");
            }
        }
        request.setAttribute("resultCalo", sb);
        request.getRequestDispatcher("main.jsp").forward(request, response);
	}
	public void searchpw(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	       String id = request.getParameter("pid");
	       String name = request.getParameter("pname");
	       String pw = man.searchpw(id, name);
	       System.out.println(pw);
	       if(pw != "")
	           request.setAttribute("pw", pw);
	       else
	           request.setAttribute("fail", "fail");
//	        request.setAttribute("id", id);
	       request.getRequestDispatcher("findpw.jsp").forward(request, response);
	   }
	
	
}
