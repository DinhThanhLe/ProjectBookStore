/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.implement.AuthorDAO;
import dal.implement.BookVariantDAO;
import dal.implement.LanguagesDAO;
import dal.implement.MaterialsDAO;
import dal.implement.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import model.Book_Variants;
import model.Books;

/**
 *
 * @author legion
 */
@MultipartConfig
public class ProductAdminController extends HttpServlet {

    private ProductDAO productDAO = new ProductDAO();
    private BookVariantDAO bookVariantDAO = new BookVariantDAO();
    private AuthorDAO authorDAO = new AuthorDAO();
    private LanguagesDAO languagesDAO = new LanguagesDAO();
    private MaterialsDAO materialsDAO = new MaterialsDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case "add":
                addProduct(request);
                break;
            case "delete":
                deleteProduct(request);
                break;
            case "edit":
                editProduct(request);
                break;
            default:
                throw new AssertionError();
        }
        response.sendRedirect("dashboard");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void addProduct(HttpServletRequest request) {
        try {
            String title = request.getParameter("title");
            String description = request.getParameter("description");

            String authorName = request.getParameter("author");
            String languageName = request.getParameter("languages");
            String materialType = request.getParameter("material");
            double price = Double.parseDouble(request.getParameter("price"));
            int category_id = Integer.parseInt(request.getParameter("category"));
            int stockQuantity = Integer.parseInt(request.getParameter("quantity"));
            //image
            Part part = request.getPart("image"); // Lấy phần dữ liệu gửi lên có tên là "image"
            String fileName = part.getSubmittedFileName();
// Đường dẫn thư mục để lưu ảnh (trong thư mục "images" của ứng dụng)
            String path = request.getServletContext().getRealPath("/img/product");

// Tạo đối tượng File đại diện cho thư mục lưu ảnh
            File dir = new File(path);

// Kiểm tra xem thư mục đó đã tồn tại chưa, nếu chưa thì tạo mới
            if (!dir.exists()) {
                dir.mkdirs();
            }

// Tạo file ảnh trong thư mục trên, với tên gốc từ file được gửi lên
            File image = new File(dir, part.getSubmittedFileName());

// Ghi dữ liệu từ phần upload vào file ảnh
            part.write(image.getAbsolutePath());

            // 1. Kiểm tra và thêm tác giả nếu chưa tồn tại
            int authorId = authorDAO.insertIfNotExists(authorName);

            // 2. Kiểm tra và thêm ngôn ngữ nếu chưa tồn tại
            int languageId = languagesDAO.insertIfNotExists(languageName);

            // 3. Kiểm tra và thêm chất liệu nếu chưa tồn tại
            int materialId = materialsDAO.insertIfNotExists(materialType);

            // Kiểm tra và thêm sách nếu sách chưa tồn tại 
            int bookId;
            if (productDAO.checkExistBook(title) > 0) {
                bookId = productDAO.checkExistBook(title);
            } else {
                Books newBook = Books.builder()
                        .title(title)
                        .description(description)
                        .cover_image_url(fileName)
                        .category_id(category_id)
                        .author_id(authorId)
                        .build();

                bookId = productDAO.insert(newBook);
            }

            if (bookId > 0 && !bookVariantDAO.checkDuplicate(bookId, materialId, languageId)) {
                // 5. Thêm biến thể sách vào bảng Book_Variants
                Book_Variants newVariant = Book_Variants.builder()
                        .book_id(bookId)
                        .material_id(materialId)
                        .language_id(languageId)
                        .price(price)
                        .stock_quantity(stockQuantity)
                        .build();

                int variantId = bookVariantDAO.insert(newVariant);
                System.out.println("Variant ID được tạo: " + variantId);
            }

        } catch (ServletException | IOException | NumberFormatException e) {
            System.err.println("Lỗi khi thêm sản phẩm: " + e.getMessage());

        }

    }

    private void deleteProduct(HttpServletRequest request) {

        int idBookVar = Integer.parseInt(request.getParameter("idBookVar"));

        bookVariantDAO.deleteBookById(idBookVar);

        // kiểm tra có id còn trong variants
        int idBook = Integer.parseInt(request.getParameter("idBook"));

        if (!bookVariantDAO.isLastVariantDeleted(idBook)) {
            productDAO.deleteBookById(idBook);
        }

    }

    private void editProduct(HttpServletRequest request) {

        try {
            int idVar = Integer.parseInt( request.getParameter("idVar"));
            int  idBook = Integer.parseInt(request.getParameter("idBook"));
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            double price = Double.parseDouble(request.getParameter("price")) ;
            int quantity = Integer.parseInt(request.getParameter("quantity")); 
            int categoryId = Integer.parseInt(request.getParameter("category"));
            
            String description = request.getParameter("description");
            // Lấy part chứa ảnh
            Part part = request.getPart("image");

// Lấy tên file (tránh null)
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

// Đường dẫn thư mục gốc lưu ảnh (trên server)
            String uploadPath = request.getServletContext().getRealPath("") + File.separator + "img" + File.separator + "product";

// Tạo thư mục nếu chưa có
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

// Ghi file vào thư mục 
            String filePath = uploadPath + File.separator + fileName;
            part.write(filePath);
          
            int authorId = authorDAO.insertIfNotExists(author) ;
            
            Books bookUpdate = Books.builder()
                        .book_id(idBook)
                        .title(title)
                        .description(description)
                        .cover_image_url(fileName)
                        .category_id(categoryId)
                        .author_id(authorId)
                        .build();
            
            productDAO.updateBook(bookUpdate) ;
            
            
            Book_Variants bookVarUpdate = Book_Variants.builder()
                                         .variant_id(idVar)
                    
                    .price(price)
                    .stock_quantity(quantity)
                    .build() ;
            
            bookVariantDAO.updateBookVar(bookVarUpdate) ;
                    
                        
            
        } catch (Exception e) {
        }

    }

}
