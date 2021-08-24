package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Transactional
@SpringBootTest
class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product = new Product("apples");
        Item item1 = new Item(new BigDecimal(5), 20, new BigDecimal(100));
        Item item2 = new Item(new BigDecimal(5), 100, new BigDecimal(500));
        item1.setProduct(product);
        item2.setProduct(product);

        Invoice invoiceList = new Invoice("2021/8/23/0001");
        invoiceList.getItems().add(item1);
        invoiceList.getItems().add(item2);
        product.getItems().add(item1);
        product.getItems().add(item2);

        item1.setInvoice(invoiceList);
        item2.setInvoice(invoiceList);

        //When
        invoiceDao.save(invoiceList);
        int id = invoiceList.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        try {
            invoiceDao.deleteById(id);
        } catch (Exception e) {
            //do nothing
        }
    }

}