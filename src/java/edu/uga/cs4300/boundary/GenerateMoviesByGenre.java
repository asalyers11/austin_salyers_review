/*
Austin Salyers
 */
package edu.uga.cs4300.boundary;


import edu.uga.cs4300.logiclayer.MovieLogicImpl;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GenerateMoviesByGenre extends HttpServlet {

    private Configuration   cfg = null;
    static  String          templateDir = "/WEB-INF/templates";
    static  String          resultTemplateName = "GenerateMoviesByGenre-Result.ftl";
    
    @Override
    public void init() { 
        
        cfg = new Configuration(); //Configuration.VERSION_2_3_25
        // Specify the source where the template files come from.
        cfg.setServletContextForTemplateLoading(getServletContext(), templateDir);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
    {
        Template            resultTemplate = null;
        String              genre;
        ArrayList<String>   movieTitles;
        
        // load the template
        try {
            resultTemplate = cfg.getTemplate( resultTemplateName );
        } 
        catch (IOException e) {
            throw new ServletException( "ViewMoviesByGenreServlet.processRequest: Can't load template in: " + templateDir + ": " + e.toString());
        }
                
        // set up the response writer
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter toClient = response.getWriter();

        // load html parameter values
        genre = request.getParameter("genre");
        
        // business logic
        movieTitles = MovieLogicImpl.findMovieTitlesByGenre( genre );

        // create the data model
        Map<String, Object> root = new HashMap<String, Object>();
        root.put( "genre", genre );
        root.put("movieTitles", movieTitles);
        
        // connect template with data model
        try {
            resultTemplate.process( root, toClient );
        } 
        catch (TemplateException e) {
            throw new ServletException( "Error while processing FreeMarker template", e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
