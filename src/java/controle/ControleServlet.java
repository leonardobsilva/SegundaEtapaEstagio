package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*Arquivo java*/
@WebServlet(name = "ControleServlet", urlPatterns = {"/ControleServlet"})
public class ControleServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*Declaração de variaveis buscando os conteudos das variaveis do formulario do arquivo index*/
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String resposta = request.getParameter("resposta");
        String escolhida = "";

        /*A variavel escolha recebe uma mensagem diferente condicionada ao valor passado para variavel resposta pelo formulario index*/
        switch(resposta){
            case "1":
                escolhida = "Quero ter um bom salário.</p></p>Desculpe mas você não foi selecionado!";
                break;
            case "2":
                escolhida = "Quero ter o título de NERD.</p></p>Desculpe mas você não foi selecionado!";
                break;
            case "3":
                escolhida = "Quero ser um profissional desenvolvedor de software por toda vida.</p></p>PARABÉNS, CERTA RESPOSTA, A VAGA É SUA!!!";
                break;
            default:
                escolhida = "Você deve escolher uma das resposta!";
                break;
            
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* Uma nova pagina é carregada*/
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            /*Mensagem final que carrega as variaves "nome, telefone e escolhida" informando ao usuario o resultado da resposta*/
            out.println("<h1>Olá "+nome+"</br>Contato: "+telefone+"</br>Obrigado por participar do nosso QUIZ.</p></p>Sua resposta foi: "+escolhida+"</h1>");
            out.println("</body>");
            out.println("</html>");
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
