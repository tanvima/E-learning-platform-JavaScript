
package com.cybage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;

import com.cybage.dao.AdminDao;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.Video;

import junit.framework.TestCase;
import net.bytebuddy.asm.Advice.Return;

public class AdminServiceImplMockTest extends TestCase {

       private AdminDao admindao = Mockito.mock(AdminDao.class);
       
       private AdminService adminservice = new AdminServiceImpl(admindao);
       
       public void testAddCategory() throws SQLException {
              Category c = new Category("java", "java is best language for programming");
              Mockito.when(admindao.addCategory(c)).thenReturn(1);
              
              int addCount = adminservice.addCategory(c);   //admindao add category
              assertEquals(1, addCount);
              
              
       }

       public void testGetAllCategory() throws SQLException {
              List<Category> c = new ArrayList<Category>();
              c.add(new Category("java", "java is best language for programming"));
              c.add(new Category("C", "C is basic programming language"));
              Mockito.when(admindao.getAllCategory()).thenReturn(c);
              
              List<Category> category = adminservice.getAllCategory();
              assertIterableEquals(c, category);
       }

       public void testGetCategory() throws SQLException {
              Category c = new Category("java", "java is best language for programming");
              Mockito.when(adminservice.getCategory("java")).thenReturn(c);
              assertEquals("java", c.getCategoryname());
              assertEquals("java is best language for programming", c.getCategorydescription());
       }

       public void testUpdateCategory() throws SQLException, IOException {
              Category c = new Category("java", "java is best language for programming");
              Mockito.when(admindao.updateCategory(c)).thenReturn(1);
              int addCount = adminservice.updateCategory(c);       //admindao add category
              assertEquals(1, addCount);
              
       }

       public void testDeleteCategory() throws SQLException {
              String categoryname = "java";
              Mockito.when(admindao.deleteCategory(categoryname)).thenReturn(1);
              
              int addCount = adminservice.deleteCategory(categoryname);  //admindao add category
              assertEquals(1, addCount);
              
       }

       public void testGetAllCourse() throws SQLException {
              String categoryname = "java";
              List<Course> course = new ArrayList<Course>();
              course.add(new Course("advance java","it is good", 1120));
              course.add(new Course("core java","it is better", 650));
              
              Mockito.when(admindao.getAllCourse(categoryname)).thenReturn(course);
              
              List<Course> courseFromService = adminservice.getAllCourse(categoryname);
              assertIterableEquals(course, courseFromService);
              
       }

       public void testAddCourse() throws SQLException {
              Course c = new Course("core java","it is better", 650);
              String categoryname = "java";
              Mockito.when(admindao.addCourse(c, categoryname)).thenReturn(1);
              
              int addCount = adminservice.addCourse(c, categoryname);    //admindao add category
              assertEquals(1, addCount);
       }

       public void testDeleteCourse() throws SQLException {
              int courseid = 1;
              Mockito.when(admindao.deleteCourse(courseid)).thenReturn(1);
              
              int addCount = adminservice.deleteCourse(courseid); //admindao add category
              assertEquals(1, addCount);
       }

       public void testGetCourse() throws SQLException {
              Course c = new Course("core java","it is better", 650);
              int courseid = 1;
              Mockito.when(adminservice.getCourse(courseid)).thenReturn(c);
              assertEquals("core java", c.getCoursename());
              assertEquals("it is better", c.getCoursedescription());
       }

       public void testUpdateCourse() throws SQLException, IOException {
              Course c = new Course("core java","it is better", 650);
              Mockito.when(admindao.updateCourse(c)).thenReturn(1);
              int addCount = adminservice.updateCourse(c);  //admindao add category
              assertEquals(1, addCount);
              
       }

       public void testGetAllVideo() throws SQLException {
              int courseid = 1;
              List<Video> video = new ArrayList<Video>();
              video.add(new Video("introduction", "sample1.mp4", 1));
              video.add(new Video("basic", "sample2.mp4", 2));
              
              Mockito.when(admindao.getAllVideo(courseid)).thenReturn(video);
              
              List<Video> videoFromService = adminservice.getAllVideo(courseid);
              assertIterableEquals(video, videoFromService);
       }

       public void testAddVideo() throws SQLException {
              Video v = new Video("introduction", "sample1.mp4", 1);
              int courseid = 1;
              Mockito.when(admindao.addVideo(v, courseid)).thenReturn(1);
              
              int addCount = adminservice.addVideo(v, courseid);  //admindao add category
              assertEquals(1, addCount);
       }

       public void testGetVideo() throws SQLException {
              Video v = new Video("introduction", "sample1.mp4", 1);
              int videoid = 1;
              Mockito.when(adminservice.getVideo(videoid)).thenReturn(v);
              assertEquals("introduction", v.getVideoname());
              assertEquals("sample1.mp4", v.getVideopath());
              assertEquals(1, v.getVideoseq());
       }

       public void testUpdateVideo() throws SQLException {
              Video v = new Video("introduction", "sample1.mp4", 1);
              int videoid = 1;
              Mockito.when(admindao.updateVideo(v, videoid)).thenReturn(1);
              int addCount = adminservice.updateVideo(v, videoid); //admindao add category
              assertEquals(1, addCount);
       }

       public void testDeleteVideo() throws SQLException {
              int videoid = 1;
              Mockito.when(admindao.deleteVideo(videoid)).thenReturn(1);
              
              int addCount = adminservice.deleteVideo(videoid);    //admindao add category
              assertEquals(1, addCount);
       }

}






