package edu.mum.cs;

import model.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(urlPatterns = {"/quiz"})
public class QuizServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int totalScore = 0;
        int[] numbers = {2,4,5,6,7};
        int answer = 9;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        //Getting the choice from the String
        String choice = req.getParameter("num");
        Integer val = Integer.valueOf(choice);
        if(val.equals(answer)){
            totalScore++;
        }

        HashMap<Integer,int[]> resultsHashMap = Quiz.loopThroughQuiz();

        HttpSession session = req.getSession(false);
        if (session == null){
            List<Integer> list = new ArrayList<>(resultsHashMap.keySet());
            Collections.shuffle(list);

            Map<Integer, int[]> shuffleMap = new LinkedHashMap<>();
            list.forEach(k->shuffleMap.put(k, resultsHashMap.get(k)));
        }
        String output =
                "</html>" +
                    "</body>" +
                        "<div>" +
                            "<form action=\"quiz\" method=\"POST\">" +
                                "<h3>The Number Quiz </h3>" +
                                "<p> Your current Score is "+ totalScore + "</p>" +
                                "<p> Guess the next number in the sequence </p>" +
                                "<p>" + Arrays.toString(numbers)+ "</p>" +
                                "<p>Your answer : <input type=\"number\" name=\"num\" value="+">" + "</p>" +
                                "<p><input type=\"submit\" value=\"Submit\">" + "</p>" +
                            "</form>" +
                        "</div>" +
                    "</body>" +
            "</html>";

        out.println(output);

    }

}
