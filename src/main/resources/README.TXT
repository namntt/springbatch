Link: https://docs.spring.io/spring-batch/4.0.x/reference/html/domain.html#domainLanguageOfBatch
https://docs.spring.io/spring-batch/4.0.x/reference/html/job.html#configureJob
https://docs.spring.io/spring-batch/4.0.x/reference/html/step.html#configureStep
https://docs.spring.io/spring-batch/4.0.x/reference/html/readersAndWriters.html#readersAndWriters
https://docs.spring.io/spring-batch/4.0.x/reference/html/scalability.html#scalability
-Trong spring batch, 1 Job thi don gian laf 1 container cho the hien Step. No ket hop nhieu steps thuoc cung login trong 1 luong.
Cau hinh job chua:
+Ten job
+Dinh nghia va sap xep cac the hien Step
+Job co duoc khoi dong lai hay khong

///Code
@Bean
public Job footballJob() {
    return this.jobBuilderFactory.get("footballJob")
                     .start(playerLoad())
                     .next(gameLoad())
                     .next(playerSummarization())
                     .end()
                     .build();
}

1. JobInstance
- Moi JobInstance co the co nhieu lan thuc thi
- Chỉ một JobInstance tương ứng với một Job cụ thể và việc xác định JobParameters có thể chạy tại một thời điểm nhất định.

2. JobParameters
-1 cau hoi dat ra lam the nao de 1 JobInstance co the phan biet voi nhau?
=> cau tra loi la JobParameters. 1  doi tuong JobParameters chua dung 1 tap cac tham so duoc su dung bat dau 1 batch job.
Chung co the duoc su dung de dinh danh hoac than chieu den du lieu trong thoi gian chay
-Vi du: co hai truong hop, 1 cho ngay 1/1 va 1/2, chi co mot Job, nhung no co 2 doi tuong JobParameter: 1 cai duoc bat dau
voi 1 job parameter 1/1/2017 va voi 1 job parameter 1/2/2017. Nhu vay, ta co the dinh nghia duoc
JobInstance = Job + identifying JobParameters. Cho phep cac nha phat trien kiem soat hieu qua cach xac dinh JobInstance.
=> khong phai tat ca cac job parameters duoc yeu cau dong gop dinh danh cua JobInstance. Mac dinh, chung se lam nhu vay.
Tuy nhien , framework cho phep gui 1 Job ma khong can dinh danh cua 1 JobInstance.

3. JobExecution
4. Step
-Moi Job bao gom 1 hoac nhieu steps.
-Mot Step chua dung tat ca thong tin can thiet de dinh nghia va dieu khien batch processing.
-Mot Step co 1  StepExecution duy nhat tung ung voi JobExecution duy nhat
4.1. StepExecution
-1 new StepExecution duoc khoi tao moi lan Step chay, tuong tu nhu JobExecution. Tuy nhien, neu step thuc thi that bai boi vi step truoc
no that bai, se khong duy tri viec thuc thi cho no. Mot StepExecution duco khoi tao chi kho Step do da duoc bat dau.
