package crm.entity;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class UserDetail {
@SerializedName("id")
 @Expose
 private Integer id;
 @SerializedName("username")
 @Expose
 private String username;
 @SerializedName("firstName")
 @Expose
 private String firstName;
 @SerializedName("lastName")
 @Expose
 private String lastName;
 @SerializedName("password")
 @Expose
 private String password;
 @SerializedName("email")
 @Expose
 private String email;


 public Integer getId() {
  return id;
 }
 public String getLastName() {
	  return lastName;
	 }
 public String getFirstName() {
	  return firstName;
	 }
 public String getPassword() {
	  return password;
	 }
 public String getEmail() {
	  return email;
	 }
 
 public void setId(Integer id) {
  this.id = id;
 }
 public String getUsername() {
  return username;
 }
 public void setEmail(String email){
	 this.email = email;
 }
 public void setUsername(String username) {
  this.username = username;
 }
 public void setFirstName(String username) {
	  this.firstName = username;
 }
 public void setLastName(String username) {
	  this.lastName = username;
 }
 public void setPassword(String password){
	 this.password = password;
 }
}