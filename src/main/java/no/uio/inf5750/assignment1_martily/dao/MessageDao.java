package no.uio.inf5750.assignment1_martily.dao;

import no.uio.inf5750.assignment1_martily.model.Message;
import java.util.List;

public interface MessageDao
{
    int save( Message message );
    Message get( int id );
    Message getLast();    
    List<Message> getAll();
}