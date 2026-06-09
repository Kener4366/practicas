import java.time.LocalDateTime;

public class TratamientoDental {
    private LocalDateTime fechaHora;
    private String descripcion;
    private String recomendacion;

    public TratamientoDental(LocalDateTime fechaHora,
                             String descripcion,
                             String recomendacion) {
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
        this.recomendacion = recomendacion;
    }


    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getRecomendacion() {
        return recomendacion;
    }



    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }
}