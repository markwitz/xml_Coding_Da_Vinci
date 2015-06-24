class DefaultController < ApplicationController
  def member
    @document = Nokogiri::XML(File.read('xml_member.xml'))
    template = Nokogiri::XSLT(File.read('app/views/default/member.xslt'))
    @member = template.transform(@document)
  end
end
