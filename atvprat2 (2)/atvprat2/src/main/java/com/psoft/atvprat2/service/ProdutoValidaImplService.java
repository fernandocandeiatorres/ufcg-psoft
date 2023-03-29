package com.psoft.atvprat2.service;

import com.psoft.atvprat2.model.Produto;
import com.psoft.atvprat2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoValidaImplService implements ProdutoValidaService {

    @Autowired
    ProdutoRepository<Produto, Long> produtoRepository;

    @Override
    public boolean validaCodigo(Produto produto) {
        String codigo = produto.getCodigoBarra();

        char[] arr = codigo.toCharArray();
        int digitoVerificador = Integer.parseInt(String.valueOf(arr[arr.length-1]));
        int firstSum = 0;
        int secondSum = 0;
        for(int i = arr.length - 2; i >= 0; i--){
            Integer num = Integer.parseInt(String.valueOf(arr[i]));
            if(num % 2 == 0){
                secondSum += num;
            } else {
                firstSum += num;
            }
        }
        int result = (firstSum*3)+secondSum;
        int count = 0;
        while (result % 10 != 0){
            result += 1;
            count++;
        }

        return count == digitoVerificador;
    }
}
