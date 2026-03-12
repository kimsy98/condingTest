-- 코드를 입력하세요
SELECT b.category, SUM(s.sales) TOTAL_SALES from BOOK b join BOOK_SALES s on b.BOOK_ID= s.BOOK_ID
where s.SALES_DATE like '2022-01%'
group by b.category
order by b.category

# select * , SUM(b.sales) from book_sales b where b.sales_date like '2022-01%'
# and b.book_id =3
# group by book_id