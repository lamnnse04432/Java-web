package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"resources/css/Header.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"resources/css/main.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("        <title>Home</title>\n");
      out.write("    </head>\n");
      out.write("    <script src=\"resources/js/main.js\" type=\"text/javascript\"></script>\n");
      out.write("    <body> \n");
      out.write("        <script>\n");
      out.write("            function myFunction() {\n");
      out.write("                var fromCity = document.getElementById(\"fromCity\").value;\n");
      out.write("                var toCity = document.getElementById(\"toCity\").value;\n");
      out.write("                var depart = document.getElementById(\"depart\").value;\n");
      out.write("                var xReturn = document.getElementById(\"xReturn\").value;\n");
      out.write("                var xReturn = document.getElementById(\"xReturn\").value;\n");
      out.write("                var ticket = document.getElementById(\"ticket\").checked;\n");
      out.write("                var checkCity = false;\n");
      out.write("                var checkDate = false;\n");
      out.write("               \n");
      out.write("                if (ticket == false) {\n");
      out.write("                    if (fromCity == toCity) {\n");
      out.write("                        alert('Please chossen from city and to city is diffrent !');\n");
      out.write("                        checkCity = true;\n");
      out.write("                    }\n");
      out.write("                    if (checkCity == false) {\n");
      out.write("                        return true;\n");
      out.write("                    } else {\n");
      out.write("                        return false\n");
      out.write("                    }\n");
      out.write("                } else {\n");
      out.write("                    if (fromCity == toCity) {\n");
      out.write("                        alert('Please chossen from city and to city is diffrent !');\n");
      out.write("                        checkCity = true;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    if (depart == xReturn) {\n");
      out.write("                        alert('Please chossen department and return is diffrent !');\n");
      out.write("                        checkDate = true;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    if (checkCity == false && checkDate == false) {\n");
      out.write("                        return true;\n");
      out.write("                    } else {\n");
      out.write("                        return false\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function show() {\n");
      out.write("               \n");
      out.write("                document.getElementById(\"test\").hidden=false;\n");
      out.write("            }\n");
      out.write("             function hide() {\n");
      out.write("                 \n");
      out.write("                document.getElementById(\"test\").hidden=true;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <div id=\"page-wrapper\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write(" \n");
      out.write("            <div id=\"wrapper\" class=\"home\">\n");
      out.write("                <div class=\"main\">\n");
      out.write("                    <form id=\"search\" action=\"BookingServlet\" method=\"POST\" onsubmit=\"return myFunction()\"></form>\n");
      out.write("                    <h1 class=\"default\">Flight</h1>\n");
      out.write("                    <table class=\"home-tripform\">\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"radio\" id=\"ticket\" name=\"ticket\" value=\"roundtrip\"  form=\"search\" onclick=\"show()\" />Round trip\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"radio\" name=\"ticket\" value=\"oneway\" form=\"search\"  onclick=\"hide()\"  checked/>One way\n");
      out.write("\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                Room :\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("\n");
      out.write("                                <select id=\"fromCity\" name=\"fromCity\" form=\"search\">\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                To : \n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <select id=\"toCity\"  name=\"toCity\" form=\"search\">\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                Departure : \n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input id=\"depart\" type=\"date\" name=\"departure\" form=\"search\"  value=\"\" required />\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr hidden=\"true\"   id=\"test\">\n");
      out.write("                            <td >\n");
      out.write("                                Return : \n");
      out.write("                            </td>\n");
      out.write("                            <td >\n");
      out.write("                                <input id=\"xReturn\" type=\"date\" name=\"return\" form=\"search\"  value=\"\" /> \n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"2\">\n");
      out.write("                                <input class=\"button default\" type=\"submit\" value=\"search\" form=\"search\" name=\"btnSearch\" >\n");
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listC}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("m");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(" \n");
          out.write("                                        <option  value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${m.cityName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${m.cityName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listC}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("m");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(" \n");
          out.write("                                        <option  value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${m.cityName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${m.cityName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
