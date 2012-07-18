<#import "/application.ftl" as layout />

<@layout.template 'Saved Order' >
<div class="form_background">
    <#if order??>
       <div class="header">Order Saved!</div>

       <div>
           <div id="order_salutation" class="order_text">Dear ${order.name},</div>

           <div class="order_text">
                Your order for <b>${order.item.name}</b> was submitted.
           </div>

           <div class="order_email">This order can be tracked with your email, ${order.email}.</div>
       </div>

       <div id="total_container">
           <label for="total">Total: </label>
           <input name="total" value=${order.total} readonly="readonly" type="text"/>
       </div>
    <#else>
        <div>Sorry the order was not saved..</div>
    </#if>
</div>
</@layout.template>