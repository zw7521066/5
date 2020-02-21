
    /** 
     
       * Test method for {@link com.bleum.canton.ca.category.dao.impl.CategoryDao#updateCategory(com.bleum.canton.ca.category.entity.Category)}. 
     
       */ 
     
      @Test 
     
      public void testUpdateCategory() { 
     
          assertTrue(applicationContext !=null); 
     
          assertTrue (categoryDao !=null); 
     
          
     
          //create a root category 
     
          Category rootCat = new Category(); 
     
          rootCat.setCategoryCode("rootCat1234567"); 
     
          rootCat.setCategoryName("TestRootCategory"); 
     
          rootCat.setStatus(1); 
     
          rootCat.setLevel(1); 
     
          rootCat.setVersion(0.1f); 
     
          rootCat.setCreatedBy("charles.wang"); 
     
          rootCat.setLastModifiedBy("charles.wang"); 
     
          rootCat.setParentID("0"); 
     
          Timestamp today = new Timestamp(System.currentTimeMillis());        
     
          rootCat.setCreatedDate(today  ); 
     
          rootCat.setLastModifiedDate(today); 
     
               
     
          
     
          //add this category 
     
          categoryDao.addCategory(rootCat); 
     
          
     
          
     
     
     
          //get the category that we need to update 
     
          Category needToUpdateCategory =categoryDao.findCategoryByCategoryCode("rootCat1234567"); 
     
          assertNotNull(needToUpdateCategory); 
     
     
     
          //////////////////////////////////// 
     
          //the method that needs to be tested 
     
          
     
          //we update this category 
     
          needToUpdateCategory.setCategoryName("TestRootCategoryRename"); 
     
          categoryDao.updateCategory(needToUpdateCategory); 
     
          
     
          //to conclusion whether the category has been updated 
     
          Category afterUpdatedCategory =categoryDao.findCategoryByCategoryCode("rootCat1234567"); 
     
          assertNotNull(afterUpdatedCategory); 
     
          String newCategoryName = afterUpdatedCategory.getCategoryName(); 
     
          assertTrue("TestRootCategoryRename".equals(newCategoryName)); 
     
     
     
          //remove this test category from the database 
     
          categoryDao.delCategoryByCategoryCode("rootCat1234567"); 
     
      } 
