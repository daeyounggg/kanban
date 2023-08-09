package models.works;

public class DeleteService {
    private WorkDao workDao = new WorkDao();

    public DeleteService(WorkDao workDao){
        this.workDao = workDao;
    }

    public void delete(long workNo){

        if(!workDao.exists(workNo)){
            throw new WorkNotFoundException();
        }

        if(!workDao.delete(workNo)) {
            throw new WorkDeleteException();
        }
    }

}
