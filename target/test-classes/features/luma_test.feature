@magento_market
Feature: magento market

  Background:
  Given Navigate to the home page
    Scenario Outline: customer_purchase_product
      And user enters existing email as "<email>" and  password "<password>"
      When customer goes to women section select tees and click
      Then select Gwyn Tee and click medium size and green color
      And hover over and click Add to cart
#     And verify the message
      And click the number next to cart symbol
      And click on qty box and change the number and click update
      And customer click proceed button and verifies address
      When customer return previous page and click on view edit
      Then verify discount applied
      And change the quantity and click Update
      And customer return women department page
      And choose the item and add to the basket
      And goes to the fitness page and select the item
      And checks the cart and verifies total amount
      Examples: test data for existing customer
        | email        |password|
        |raya@gmail.com|raya@gmail.com12|






