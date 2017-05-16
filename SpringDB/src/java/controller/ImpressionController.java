/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import model.Impression;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author CatalinRosu
 */
@Controller
public class ImpressionController {
    
    @RequestMapping(value = "/form", method =RequestMethod.GET)
 public String createForm(ModelMap model) throws ClassNotFoundException, SQLException {
     
 model.addAttribute("impression", new Impression());
 model.addAttribute("impressions",Impression.allImpressions());
 
 return "form";
 
 }
 @RequestMapping(value = "/form", method = RequestMethod.POST)
 public String addImpression(@ModelAttribute("impression") Impression impression, ModelMap model) throws ClassNotFoundException, SQLException {
     
                 impression.insertImpression();

                createForm(model);
 
                return "form";
 }

    
}
