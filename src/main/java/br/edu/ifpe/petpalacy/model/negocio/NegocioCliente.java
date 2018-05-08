/*
MIT License

Copyright (c) 2018 Daniel da Silva Calado, Izaquiel Cavalcante da Silva, 
                   Kaio Cesar Bezerra da Silva e Wemerson Diogenes da Silva

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package br.edu.ifpe.petpalacy.model.negocio;

import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.interfaces.InterfaceCliente;
import br.edu.ifpe.petpalacy.model.repositorio.implementacao.RepositorioClienteImpDB;
import java.util.List;

/**
 *
 * @author Wemerson Diogenes da Silva <wemersondiogenes16@gmail.com>
 */


public class NegocioCliente implements InterfaceCliente<Cliente>{
    
    private RepositorioClienteImpDB repCliente;
    private Cliente cli;
    
    public NegocioCliente(){
        repCliente = new RepositorioClienteImpDB();
    }

    @Override
    public Cliente autenticar(String login, String senha) {
        if(login == null || senha == null){
            return null;
        }
        return((RepositorioClienteImpDB)repCliente).autenticar(login,senha);
    }

    @Override
    public Cliente buscarCpf(String cpf) {
        if(cpf == null){
            return null;
        }else{
            cli = repCliente.buscarCpf(cpf);
            if(cli == null){
                return null;
            }else{
                return cli;
            }
        }
    }
    
    @Override
    public void salvar(Cliente cliente){
        if(cliente == null){
            
        }else{
            if(buscarCpf(cliente.getCpf())!= null){
                
            }else{
                repCliente.salvar(cliente);
            }
        }
    }
    
    @Override
    public Cliente buscar(Integer codigo){
        if(codigo == null){
            return null;
        }else{
            cli = repCliente.buscar(codigo);
            if(cli == null){
                return null;
            }else{
                return cli;
            }
        }
    }
    
    @Override
    public void editar(Cliente cliente){
        if(cli == null){
            
        }else{
            cli = repCliente.buscar(cliente.getIdCliente());
            if(cli == null){
                System.out.println("");
            }else{
                repCliente.editar(cliente);
            }
        }
    }
    
    @Override
    public void deletar(Cliente cliente){
        if(cliente == null){
            
        }else{
            cli = repCliente.buscar(cliente.getIdCliente());
            if(cli == null){
                System.out.println("");
            }else{
                repCliente.deletar(cliente);
            }
        }
    }
    
    @Override
    public List<Cliente> listar(){
        List lista = repCliente.listar();
        if(lista == null){
            return null;
        }else{
            return lista;
        }
    }
}