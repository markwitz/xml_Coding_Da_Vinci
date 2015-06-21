class DefaultController < ApplicationController
  def member
    @document = Nokogiri::XML(File.read('xml.xml'))
    template = Nokogiri::XSLT(File.read('app/views/default/member.xslt'))
    @member = template.transform(@document)
  end
end
