package br.edu.ibmec.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
@Service
public class AzureStorageAccountService {

    public String uploadFileToAzure(MultipartFile file) throws IOException{
        String connectionString = "DefaultEndpointsProtocol=https;AccountName=ibmecarmazenamentorc;AccountKey=yiih0lKsAvYJEfzH8JmvOVLjraY0yj9AzlUZaAoK4jg3Nf8q3gWscYnQ3zV8/WuH2m5OD2pr/978+AStQ/EG0g==;EndpointSuffix=core.windows.net";
        
        BlobContainerClient client = new BlobContainerClientBuilder()
            .connectionString(connectionString)
            .containerName("images")
            .buildClient();
        BlobClient blob= client.getBlobClient(file.getOriginalFilename());

        blob.upload(file.getInputStream(), file.getSize(), true);
    
        return "https://ibmecarmazenamentorc.blob.core.windows.net/images/" +file.getOriginalFilename();
        
    }
    
}
