package models.works;

public class DeleteService {
    private WorkDao workDao = new WorkDao();

    public DeleteService(WorkDao workDao){
        this.workDao = workDao;
    }

    public void delete(long workNo){
        boolean result = workDao.delete(workNo);
        if(!result){
            throw new WorkDeleteException();
        }
    }
}
